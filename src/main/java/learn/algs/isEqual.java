package learn.algs;

public class isEqual {
  public static void main(String[] args) {
    int nargin = args.length;
    if (nargin != 3)
      throw new IllegalArgumentException("Please input three integers only!");
    int[] numIn = new int[3];
    // parse input argument as integer
    for (int iargin = 0; iargin < 3; iargin++) {
      numIn[iargin] = Integer.parseInt(args[iargin]);
    }
    // check if they are equal
    if (numIn[0] == numIn[1] && numIn[0] == numIn[2])
      System.out.println("equal");
    else
      System.out.println("not equal");
  }
}
