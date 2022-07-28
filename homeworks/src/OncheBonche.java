import java.util.*;

public class OncheBonche {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int n = Integer.parseInt(scanner.nextLine());
            int m = Integer.parseInt(scanner.nextLine());

        int p = findWinner(n,m);
        System.out.println(p);

    }
    private static int findWinner(int n, int m) {
        List<Integer> circle = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            circle.add(i);
        }

        int participants = n;
        int currentIndex = 0;
        //играем, докато има повече от един участник
        while (participants >1){
            //итерираме през всяка една стъпка, за да актуализираме новия индекс
            //и да подсигурим, че всяка следваща крачка е в границите на листа, както и, че не е на опразнено място
            for (int i = 0; i < m-1; i++) {
                if (circle.get(indexInBounds(currentIndex, n)) == null){
                    currentIndex = indexInBounds(currentIndex, n);
                    i--;
                    continue;
                }
                currentIndex = indexInBounds(currentIndex, n);

            }
            circle.set(currentIndex, null);
            //подсигуряваме, че следващагта позиция, от която започваме броенето, не е на празно място
            //както и, че е в границите на листа
            boolean searchingNewPoint = false;
            while (!searchingNewPoint){
                if(circle.get(indexInBounds(currentIndex,n)) == null){
                    currentIndex = indexInBounds(currentIndex, n);
                    continue;
                }else{
                    searchingNewPoint = true;
                }
            }
            currentIndex = indexInBounds(currentIndex, n);
            participants --;
        }

        circle.removeAll(Collections.singleton(null));
        // или просто с итерация и проверка, премахваме null-овете
//        for (int i = 0; i < circle.size(); i++) {
//            if (circle.get(i) == null){
//                circle.remove(i);
//                i--;
//            }
//        }
        return circle.get(0);
    }

    private static int indexInBounds(int currentIndex, int n) {
        if (currentIndex + 1 < n) {
            return currentIndex + 1;
        }
        return 0;
    }

}
