class KthLargest {

  PriorityQueue<Integer> leftQue = new PriorityQueue<>(Collections.reverseOrder()), rightQue = new PriorityQueue<>();
  List<Integer> list;
  int k;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    this.list = Arrays.stream(nums).boxed()
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());

    int i = 0;
    for (; i < k - 1; i++) {
      rightQue.add(this.list.get(i));
    }
    for (; i < nums.length; i++) {
      leftQue.add(this.list.get(i));
    }
  }

  public int add(int val) {
    if (rightQue.isEmpty()) {
      if (leftQue.isEmpty()) {
        leftQue.add(val);
        return val;
      }
      int leftElem = leftQue.poll();

      leftQue.add(val);
      leftQue.add(leftElem);
      return val > leftElem ? val : leftElem;
    }
    int rightElem = rightQue.poll();
    if (rightElem <= val) {
      // return rightElem pattern
      rightQue.add(val);
      leftQue.add(rightElem);
      return rightElem;
    } else {
      // return val or leftElem (a larger one)
      if (leftQue.isEmpty()) {
        leftQue.add(val);
        rightQue.add(rightElem);
        return val;
      }
      int leftElem = leftQue.poll();
      rightQue.add(rightElem);
      leftQue.add(val);
      leftQue.add(leftElem);
      return val > leftElem ? val : leftElem;
    }
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
