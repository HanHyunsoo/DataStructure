package university.week13;

public class Sort {
	// 1차원 배열을 출력하는 함수
    public void printArray(int a[]) {
		// a라는 배열의 인덱스 0번부터 a의 마지막 인덱스까지
        for (int i = 0; i < a.length; i++)
			// 해당하는 인덱스에 있는 값을 출력한다.
            System.out.printf("%d ", a[i]);
		// 개행
        System.out.println();
    }

	// 병합할 때 값을 넣는 배열, 정렬하고싶은 배열의 크기보다 커야되므로 30으로 선언
    private int mergedArray[] = new int[30];

	// 병합하는 함수 매개변수로 배열(a)과 배열의 시작 인덱스(begin), 배열의 끝 인덱스(end)를 받는다.
    public void merge(int a[], int begin, int end) {

		// middle - 가운데 인덱스값
        int middle = (begin + end) / 2;
		// 커서 i의 시작점을 배열의 시작점(begin)으로 초기화
        int i = begin;
		// 커서 j의 시작점을 배열의 중간지점(begin) 다음 인덱스로 초기화
        int j = middle + 1;
		// 커서 k의 시작점을 배열의 시작점(begin)으로 초기화
        int k = begin;

		// 커서 i가 middle보다 크거나 j가 end보다 커질때까지 반복한다.
        while (i <= middle && j <= end) {
			// 만약 a[i]의 값이 a[j]의 값보다 작거나 같으면
            if (a[i] <= a[j]) {
				// mergedArray[k]에 a[i]를 저장하고 k, i 를 1씩 더한다
                mergedArray[k++] = a[i++];
			// 만약 a[j]의 값이 a[i]의 값보다 작으면
            } else {
				// mergedArray[k]에 a[j]를 저장하고 k, j 를 1씩 더한다
                mergedArray[k++] = a[j++];
            }
        }

		// 만약 i가 중간 인덱스를 넘어서면 j의 커서가 end 이하다.
        if (i > middle) {
			// t라는 변수에 j를 넣고 t가 end까지 반복한다(반복할 때마다 k, t를 1씩 더한다.)
            for (int t = j; t <= end; k++, t++) {
				// mergedArray[k]에 a[t]를 저장
                mergedArray[k] = a[t];
            }
		// 만약 i가 중간 인덱스를 안갔으면 i의 커서는 middle 이하다.
        } else {
			// t라는 변수에 i를 넣고 t가 end까지 반복한다(반복할 때마다 k, t를 1씩 더한다.)
            for (int t = i; t <= middle; k++, t++) {
				// mergedArray[k]에 a[t]를 저장
                mergedArray[k] = a[t];
            }
        }

		// end - bigin 만큼 반복
        for (int t = begin; t <= end; t++) {
			// 매개변수로 받은 a배열에 병합, 정렬된 배열(mergedArray)의 값들을 집어넣는다
            a[t] = mergedArray[t];
        }

		// 병합 정렬 출력
        System.out.printf("병합 정렬 : ");
		// a 배열을 출력하는 함수
        printArray(a);
    }

	// 배열(a)과 정렬하고 싶은 영역(begin, end)이 정해지면 그 영역을 정렬해주는 메소드
    public void mergeSort(int a[], int begin, int end) {
		// 만약 begin이 end보다 작으면
        if (begin < end) {
			// middle이라는 변수에 (begin + end) / 2의 값을 저장
            int middle = (begin + end) / 2;
			// 영역을 반으로 쪼개서 다시 함수를 호출한다.(왼쪽 부분)
            mergeSort(a, begin, middle);
			// 영역을 반으로 쪼개서 다시 함수를 호출한다.(오른쪽 부분)
            mergeSort(a, middle + 1, end);
			// merge 메소드를 호출한다.
            merge(a, begin, end);
        }
    }


	// 피봇을 리턴해주는 메소드
    public int partition(int a[], int begin, int end) {

		// L변수에 begin을 저장
        int L = begin;
		// R변수에 end를 저장
        int R = end;
		// pivot 변수에 (begin + end) / 2를 저장한다
        int pivot = (begin + end) / 2;
		// 퀵정렬 시행 출력
        System.out.printf("[퀵정렬 시행 : pivot=%d] ", a[pivot]);
		// L이 R과 같아질 때 까지 반복
        while (L < R) {
			// a[L]이 a[pivot]이상이거나 L이 R과 같아질 때까지 반복
            while ((a[L] < a[pivot]) && (L < R))
				// L에 1을 더한다
                L++;
			// a[R]이 a[pivot]미만 이거나 L이 R과 같아질 때까지 반복
            while ((a[R] >= a[pivot]) && (L < R))
				// R에 1을 더한다
                R--;
			// 만약 L이 R보다 작으면
            if (L < R) {
				// temp 변수에 a[L]을 저장
                int temp = a[L];
				// a[L]에 a[R]를 저장
                a[L] = a[R];
				// a[R]에 temp(a[L]이 바뀌기 전)을 저장
                a[R] = temp;
            }
        }
		// temp 변수에 a[pivot]을 저장
        int temp = a[pivot];
		// a[pivot]에 a[R]를 저장
        a[pivot] = a[R];
		// a[R]에 temp(a[pivot]이 바뀌기 전)을 저장
        a[R] = temp;
		// a 배열을 출력
        printArray(a);
		// L을 최종적으로 리턴한다.
        return L;
    }

	// 퀵정렬 메소드
    public void quickSort(int a[], int begin, int end) {
		// 만약 begin이 end보다 작으면
        if (begin < end) {
			// p변수에 partition 메소드를 호출해서 리턴된 값을 저장한다.
            int p = partition(a, begin, end);
			// begin 부터 p-1 까지를 정렬
            quickSort(a, begin, p - 1);
			// p + 1 부터 end 까지를 정렬
            quickSort(a, p + 1, end);
        }
    }

	// 삽입 정렬 메소드
    public void insertionSort(int a[]) {
		// 삽입 정렬 출력
        System.out.printf("삽입 정렬 시작 : ");
		// 배열 a를 출력하는 메소드
        printArray(a);
		// size에 a 배열의 길이를 저장
        int size = a.length;
		// i를 1로 초기화하고 i가 size 이상이 될 때까지 반복한다.
        for (int i = 1; i < size; i++) {
			// temp 변수에 a[i]를 저장
            int temp = a[i];
			// j 변수에 i를 저장한다.
            int j = i;
			// j 가 0이하가 되거나 a[j - 1]이 temp 이하가 될 때까지 반복
            while ((j > 0) && (a[j - 1] > temp)) {
				// a[j]에 a[j - 1]를 저장
                a[j] = a[j - 1];
				// j에 1을 뺀다.
                j--;
            }
			// a[j]에 temp를 저장한다
            a[j] = temp;
			// 삽입정렬 단계 출력
            System.out.printf("삽입정렬 %d 단계 : ", i);
			// 배열 a를 출력하는 메소드
            printArray(a);
        }
    }

	// 버블 정렬 메소드
    public void bubbleSort(int a[]) {
		// 버블 정렬 출력
        System.out.printf("버블 정렬 시작 : ");
		// a배열을 출력하는 메소드 호출
        printArray(a);
		// size 라는 변수에 a 배열 길이를 저장
        int size = a.length;
		// i를 size - 1로 초기화해서 0이 될 때까지 반복한다.
        for (int i = size - 1; i > 0; i--) {
			// 단계 출력
            System.out.printf("버블 정렬 %d 단계 : \n", size - i);
			// 0부터 i까지 반복
            for (int j = 0; j < i; j++) {
				// 만약 a[j]가 a[j + 1]보다 크면
                if (a[j] > a[j + 1]) {
					// temp라는 변수에 a[j]를 저장
                    int temp = a[j];
					// a[j]에 a[j + 1]을 저장
                    a[j] = a[j + 1];
					// a[j + 1]에 temp(a[j]가 바뀌기전)을 저장한다.
                    a[j + 1] = temp;
                }
				// a를 출력하는 메소드
                printArray(a);
            }
        }
    }

	// 선택정렬 메소드
    public void selectionSort(int a[]) {
		// 선택 정렬 출력
        System.out.printf("선택 정렬 시작 : ");
		// a배열을 출력하는 메소드 호출
        printArray(a);
		// a의 길이 - 1만큼 반복을 수행한다.
        for (int i = 0; i < a.length - 1; i++) {
			// min이라는 변수에 i를 저장한다.
            int min = i;
			// j는 i + 1부터 시작하고 a의 길이까지 반복한다.
            for (int j = i + 1; j < a.length; j++) {
				// 만약 a[j]가 a[min] 보다 작으면
                if (a[j] < a[min])
					// min 변수에 j를 저장한다.
                    min = j;
            }
			// 임시로 a[i]의 값을 temp에 저장
            int temp = a[i];
			// a[i]에 a[min]을 저장
            a[i] = a[min];
			// a[min]에 temp(a[i]가 바뀌기전)를 저장
            a[min] = temp;
			// 단계를 출력한다
            System.out.printf("선택 정렬 %d 단계 : ", i + 1);
			// 그리고 a배열을 출력한다음 다시 조건이 맞으면 for문을 반복한다.
            printArray(a);
        }
    }
}