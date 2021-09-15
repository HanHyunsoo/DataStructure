package assignment;

import java.util.ArrayList;

class Person {
	String name;
	int money;
	
	public Person(String name, int money) {
		this.name = name;
		this.money = money;
	}

	//	돈이 있으면 버스를 타고 그 사람의 소지금을 출력하고 Bus 객체의 persons에 이 객체가 추가됨, 없으면 버스비와 소지금을 출력함
	public void takeBus(Bus bus) {
		// 리스트에 이 객체가 존재하는지 판단 후 버스 탑승 가능
		if (bus.persons.contains(this)) {
			System.out.println(this.name + "님은 이미" + bus.id + "번 버스에 탑승해 있습니다.");
		} else {
			// 이번에 탑승한 인원을 포함한 총 인원이 버스의 좌석수보다 높으면 bus.persons 리스트에 추가를 못하도록 예외처리함.
			if ((bus.persons.size() + 1) <= bus.seats) {
				// 이 객체가 가지고 있는 돈이 버스의 요구 비용보다 적으면 탑승 못하게 예외처리
				if ((this.money - bus.getCost()) > 0) {
					bus.addPerson(this);
					this.money -= bus.getCost();
					System.out.println(this.name + "님이 " + bus.id + "번 버스에 탑승했습니다. 소지금은 " + this.money + "원 남았습니다.");
				} else {
					System.out.println(this.name + "님이 현재 가지고 계신 돈은 " + this.money + "원이고 버스비는 " + bus.getCost() + "원이여서 " + bus.id + "번 버스에 탑승할 수 없습니다.");
				}
			} else {
				System.out.println(this.name + "님은 자리가 없어서 " + bus.id + "번 버스를 탑승하지 못했습니다.");
			}
		}
	}
	
	public void unTakeBus(Bus bus) {
		// 리스트에 이 객체가 존재하는지 판단 후 함수 실행
		if (bus.persons.contains(this)) {
			bus.subtractPerson(this);
		} else {
			System.out.println(this.name + "님은 " + bus.id + "번 버스에 탑승하지 않았습니다.");
		}
	}
	
	public void printMoney() {
		System.out.println(name + "님이 가지고있는 돈: " + this.money + "원");
	}
}

class Bus {
	int id;
	int cost;
	int money;
	// 좌석 수 변수 선언
	int seats;
	//	passengerCount 변수 대신 Person 객체들을 저장하는 ArraryList인 persons으로 대체함.
	ArrayList<Person> persons = new ArrayList<>();

	public Bus(int id, int cost, int seats) {
		this.id = id;
		this.cost = cost;
		this.seats = seats;
	}
	
	public void addPerson(Person person) {
		this.money += this.cost;
		persons.add(person);
	}
	
	public void subtractPerson(Person person) {
		persons.remove(person);
	}
	
	public int getCost() {
		return this.cost;
	}

	public void printMoney() {
		System.out.println(this.id + "번 버스가 번 돈: " + this.money + "원");
	}

	//	탑승 총 인원 수도 출력하되 현재 탑승 인원의 이름까지 나오도록 메소드를 수정함.
	public void printPassengerCount() {
		if (this.persons.size() != 0) {
			System.out.print("탑승 인원: ");
			for (int i = 0; i < this.persons.size(); i++) {
				System.out.print(this.persons.get(i).name);
				if (i != this.persons.size() - 1) {
					System.out.print(", ");
				} else {
					System.out.println();
				}
			}
		}
		System.out.println(this.id + "번 총 탑승인원: " + this.persons.size() + "명");
	}
	
}

class ObjectExample {
	public static void main(String[] args) {
		Person personA = new Person("David", 10000);
		Person personB = new Person("Louis", 1000);
		Person personC = new Person("Tom", 5000);
		
		Bus busA = new Bus(9500, 1100, 20);
		
		personA.takeBus(busA);
		// personB는 busA가 요구하는 cost보다 money가 부족하기 때문에 탑승 불가
		personB.takeBus(busA);
		personC.takeBus(busA);
		
		personA.printMoney();
		personB.printMoney();
		personC.printMoney();

		busA.printMoney();
		busA.printPassengerCount();
		
		personA.unTakeBus(busA);
		// personB는 busA에 탑승하지 않았으므로 예외처리를 함
		personB.unTakeBus(busA);
		busA.printPassengerCount();
	}
}



