// BFS 

import java.util.LinkedList;
import java.util.Queue; 

public class BFSTraversal {
    //Variabel integer ini menyimpan jumlah node (simpul) dalam graph
    private int nodes;     
    
    //Array objek LinkedList untuk mempresentasikan adjacency list, menyimpan node tetangga yang terhubung ke node tersebut
    private LinkedList<Integer> adj[];  

    //Menyimpan node yang akan dikunjungi selama penelusuran BFS
    private Queue<Integer> vertexQueue; 

    public BFSTraversal(int vertex) {
        nodes = vertex;           //Mewakili jumlah node(simpul) dalam graph
        adj = new LinkedList[nodes];  //Untuk menyimpan daftar tetangga untuk semua simpul 

        for (int i = 0; i < vertex; i++) {
            adj[i] = new LinkedList<>();        
        }

        vertexQueue = new LinkedList<Integer>(); //Untuk mengimplementasikan fungsi antrian
    }

    public void addEdge(int source, int dest) {  //Untuk menambahkan edge antara dua node(source dan dest) dalam graph
        adj[source].add(dest);
    }

    //Mencetak representasi adjacency list dari graph
    //Jika daftar tetangga untuk i tidak kosong, ia mencetak indeks simpul yang dikonversi ke karakter menggunakan metode convert
    //Kemudian iterasi melalui tetangga dalam daftar tetangga (adj[i]) danmencetaknya menggunakan metode convert lagi
    //Terakhir, mencetak karakter baris baru
    
    public void getAdj() {
        for (int i = 0; i < nodes; i++) {
            if (adj[i].size() > 0) {            
                System.out.print(convert(i) + " --> ");
                for (int j = 0; j < adj[i].size(); j++) {
                    System.out.print(convert(adj[i].get(j)) + " ");         
                }
                System.out.println();
            }
        }
    }

    public String convert(int s) {
        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}; //Method convert angka menjadi huruf
        return alphabet[s];
    }

    public void bfs(int source) {
        boolean traversalOrder[] = new boolean[nodes];  //Menandai sebuah node sudah dikunjungi atau belum

        int visitedVertex = 0;   //Menyimpan node yang sedang dikunjungi

        traversalOrder[source] = true;  //Menandai node source yang sudah dikunjungi

        vertexQueue.add(source);    //Menambahkan node source ke antrian vertexQueue

        while (!vertexQueue.isEmpty()) {    //Loop while berlanjut selama tidak ada yang kosong
            visitedVertex = vertexQueue.poll();    //Mengambil node terdepan dari antrian
            System.out.print(convert(visitedVertex) + " ");    //Mencetak vertex pertama

            for (int tetangga : adj[visitedVertex]) {   //Mengecek tetangga dari vertex pertama
                if (!traversalOrder[tetangga]) {        //Jika node tetangga belum dikunjungi
                    traversalOrder[tetangga] = true;   //Menandai node tetangga yang sudah dikunjungi

                    vertexQueue.add(tetangga);  //Menambahkan node tetangga ke antrian (vertexQueue)
                }
            }
        }
    }
}