package university.week10;

public class Heap {
	// heapSize - 현재 힙의 사이즈
	private int heapSize;
	// itemHeap - 값들을 저장할 배열
	private int itemHeap[];

	// 힙 클래스를 생성하게되면
	public Heap() {
		// heapSize를 0으로 초기화하고
		heapSize = 0;
		// itemHeap에 값이 최대 49개(인덱스 0번은 사용 안함) 들어가는 배열을 저장.
		itemHeap = new int[50];
	}

	// 힙 사이즈를 반환하는 메소드
	public int getHeapSize() {
		// 힙사이즈를 리턴
		return this.heapSize;
	}

	// 현재 힙의 값들을 출력하는 메소드
	public void printHeap() {
		// "\nHeap >>> " 을 출력하고 그 뒤 부터 데이터들을 띄어쓰기 기준으로 출력한다.
		System.out.printf("\nHeap >>> ");
		// 힙의 처음부분(0은 비어있고 1부터 시작) 부터 끝(heapSize)까지 반복한다.
		for (int i = 1; i <= heapSize; i++)
			// 현재 반복의 인덱스를 출력
			System.out.printf("[%d] ", itemHeap[i]);
	}

	// 힙에 값을 삽입하는 메소드
	public void insertHeap(int item) {
		// 힙에 값을 삽입하므로 크기가 증가한다. heapSize를 1만큼 증가시킨다.
		heapSize++;
		// 삽입되는 데이터의 인덱스는 끝(heapSize)부분에 삽입되어야한다. 변수 idx에 heapSize를 저장한다.
		int idx = heapSize;
		// 데이터를 끝부분에 넣는다.
		itemHeap[idx] = item;

		// idx가 1이 될 때까지, 즉 root(1단계)가 될 때 까지 반복한다.
		while (idx > 1) {
			// 배열 트리에서 부모 인덱스는 자식 인덱스 / 2(여기서 소수점은 버린다)임.
			int parentIdx = idx / 2;
			// 만약 부모의 데이터가 자식의 데이터(삽입한 데이터)보다 작거나 같으면
			if (itemHeap[idx] >= itemHeap[parentIdx]) {
				//  반복문을 멈춘다.
				break;
			}
			// 부모의 데이터가 자식의 데이터보다 클 경우.
			else {
				// temp 변수에 부모의 데이터를 임시로 저장한다.
				int temp = itemHeap[parentIdx];
				// 부모의 데이터를 자식의 데이터로 바꾼다.
				itemHeap[parentIdx] = itemHeap[idx];
				// 자식의 데이터를 부모의 데이터(임시로 저장한 temp 변수)로 바꾼다.
				itemHeap[idx] = temp;
				// 그리고 idx에 부모 인덱스(=윗 단계)로 바꾸고 idx가 1(root, 1단계)이 될 때까지 값을 계속 비교하고 바꾼다.
				idx = parentIdx;
			}			
		}
	}

	// root를 삭제하는 메소드
	public int deleteHeap() {
		// 인덱스 1번은 root이므로 root의 데이터를 item이라는 변수에 저장.
		int item = itemHeap[1];
		// idx에 root 인덱스를 저장한다.
		int idx = 1;
		// root에 제일 끝(heapSize)에있는 데이터를 저장한다.
		itemHeap[idx] = itemHeap[heapSize];
		// 데이터가 한개 삭제 됬으므로 heapSize를 -1.
		heapSize--;

		// idx가 마지막 단계가 될 때까지 반복을 수행 한다.
		while (idx <= heapSize / 2) {
			// childIdx - 왼쪽 자식과 오른쪽 자식의 데이터들을 대소관계를 비교해서 나온 인덱스를 저장하는 변수
			int childIdx;
			// 왼쪽 자식의 인덱스를 구하려면 (부모 인덱스[idx] * 2)
			int leftChildIdx = idx * 2;
			// 오른쪽 자식의 인덱스를 구하려면 (부모 인덱스[idx] * 2 + 1)
			int rightChildIdx = idx * 2 + 1;
			// 만약 오른쪽 자식의 인덱스가 힙의 크기보다 작으며 오른쪽 자식의 데이터가 왼쪽 자식의 데이터보다 작으면
			if ((rightChildIdx <= heapSize) && (itemHeap[leftChildIdx] > itemHeap[rightChildIdx])) {
				// childIdx에 오른쪽 자식의 인덱스를 저장.
				childIdx = rightChildIdx;
			}
			// 위 if문식이 false면 왼쪽 자식의 데이터가 오른쪽 자식의 데이터보다 작거나 같으므로
			else {
				// childIdx에 왼쪽 자식의 인덱스를 저장.
				childIdx = leftChildIdx;
			}

			// 만약 부모의 데이터가 자식의 데이터보다 작거나 같으면
			if (itemHeap[idx] <= itemHeap[childIdx]) {
				//  반복을 멈춘다.
				break;
			}
			// 부모의 데이터가 자식의 데이터보다 클경우.
			else {
				// 자식의 데이터를 임시로 temp 변수에 저장
				int temp = itemHeap[childIdx];
				// 자식의 데이터를 부모의 데이터로 바꾼다.
				itemHeap[childIdx] = itemHeap[idx];
				// 부모의 데이터를 자식의 데이터(임시로 저장한 temp 변수)로 바꾼다.
				itemHeap[idx] = temp;
				// 그리고 idx에 자식 인덱스(=아랫 단계)로 바꾸고 idx가 heapSize / 2보다 커질 때 까지(마지막 단계가 될 때 까지) 값을 계속 비교하고 바꾼다.
				idx = childIdx;
			}
		}
		// 마지막으로 삭제된 데이터를 반환하고 함수 종료.
		return item;
	}

	public static void main(String args[]) {
		int n, item;
		Heap h = new Heap();

		h.insertHeap(13);
		h.insertHeap(8);
		h.insertHeap(10);
		h.insertHeap(15);
		h.insertHeap(20);
		h.insertHeap(19);

		h.printHeap();

		n = h.getHeapSize();
		for (int i = 1; i <= n; i++) {
			item = h.deleteHeap();
			System.out.printf("\n deleted Item : [%d]", item);
			h.printHeap();
		}
	}
}
