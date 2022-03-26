
import java.time.LocalTime;
import java.util.Scanner;

class Main {
    static final int THIRTYMINS = 30;
    static final LocalTime LEAVINGTIME = LocalTime.of(19, 30);

    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int numberOfStores = Integer.parseInt(scanner.nextLine());
        String[] twoStrings;
        
        class Store {
            String name;
            LocalTime closingTime;

            public Store(String name, LocalTime closingTime) {
                this.name = name;
                this.closingTime = closingTime;
            }

            public String getName() {
                return name;
            }

            public LocalTime getClosingTime() {
                return closingTime;
            }
        }
        
        Store[] stores = new Store[numberOfStores];
        for (int i = 0; i < numberOfStores; i++) {
            twoStrings = scanner.nextLine().split(" ");
            stores[i] = new Store(twoStrings[0], LocalTime.parse(twoStrings[1]));
        }

        for (Store store: stores) {
            if (store.getClosingTime().minusMinutes(THIRTYMINS).isAfter(LEAVINGTIME)) {
                System.out.println(store.getName());
            }
        }

    }

}