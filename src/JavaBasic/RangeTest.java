package JavaBasic;

import java.util.ArrayList;

public class RangeTest {

	public static void main(String[] args) {

		Range r1 = new Range(4, 8);
		Range r2 = new Range(9, 13);
		Range r3 = new Range(6, 12);
		// Range r4=new Range(7, 10);
		Range[] aR = new Range[] { r1, r2 };
		Range[] bR = new Range[] { r3 };
		ArrayList<Range> result = getRangeSet(aR, bR);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

	}

	public static ArrayList<Range> getRangeSet(Range[] aR, Range[] bR) {
		ArrayList<Range> ranges = new ArrayList<Range>();
		for (int i = 0; i < bR.length; i++) {
			for (int j = 0; j < aR.length; j++) {
				if (aR[j].right < bR[i].left) {
					break; // 无交集
				} else if (aR[j].right > bR[i].left) {
					int left = aR[j].left > bR[i].left ? aR[j].left
							: bR[i].left; // 选大的那个
					int right = aR[j].right < bR[i].right ? aR[j].right
							: bR[i].right; // 选小的那个
					Range range = new Range(left, right);
					ranges.add(range);
				}
			}
		}
		return ranges;
	}
}

class Range {
	int left;
	int right;

	public Range(int num1, int num2) {
		left = num1;
		right = num2;
	}

	@Override
	public String toString() {
		return " [left=" + left + ", right=" + right + "]";
	}

}
