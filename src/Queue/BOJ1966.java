package Queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1966 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        Queue<Document> queue = new LinkedList<>();

        for(int i=0; i<testCase; i++) { // N번 반복
            int documentCount = scanner.nextInt();
            int documentNumber = scanner.nextInt();

            for(int j=0; j<documentCount; j++) {
                int priority = scanner.nextInt();
                queue.add(new Document(j, priority));
            }

            int result = 1;

            while (!queue.isEmpty()) {
                Document currentDocument = queue.poll();
                boolean check = true;

                Iterator it = queue.iterator();

                while (it.hasNext()) {
                    Document value = (Document) it.next();
                    if(currentDocument.priority < value.priority) {
                        check = false;
                        break;
                    }
                }

                if(check == false) {
                    queue.add(currentDocument);
                }

                else {
                    if(currentDocument.documentNumber == documentNumber) {
                        System.out.println(result);
                    }
                    else {
                        result++;
                    }
                }
            }
        }
    }
}

class Document {
    int documentNumber;
    int priority;

    public Document(int documentNumber, int priority) {
        this.documentNumber = documentNumber;
        this.priority = priority;
    }
}