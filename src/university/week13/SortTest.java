package university.week13;

public class SortTest {
	// 메인 함수 실행
	public static void main(String args[]) {
		// { 69, 10, 30, 2, 16, 8, 31, 22 }인 a배열 생성
		int a[] = { 69, 10, 30, 2, 16, 8, 31, 22 };
		// Sort클래스를 S변수에 생성
		Sort S = new Sort();
		// 병합 정렬 실행
		S.mergeSort(a, 0, 7);
	}
}
