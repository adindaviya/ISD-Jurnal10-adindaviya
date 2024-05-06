// DFS

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DFSTraversal {

    //Variabel integer menyimpan jumlah vertex (simpul) dalam graph
    private int vertex;

    //Array objek LinkedList untuk mempresentasikan adjacency list, menyimpan node tetangga yang terhubung ke node tersebut
    private LinkedList<Integer> adj[];

    //Mencatat sebuah node telah dikunjungi selama DFS
    private boolean visited[];

    @SuppressWarnings("unchecked")  //construktor
    public DFSTraversal(int v) {
        vertex = v;
        adj = new LinkedList[vertex];   
        for (int i = 0; i < vertex; i++) {
            adj[i] = new LinkedList<>(); //Menginisialisasi struktur adjacency list
        }

        visited = new boolean[vertex];      
        for (int i = 0; i < vertex; i++) {
            visited[i] = false; //Menginisialisasi semua elemen menjadi false(belum dikunjungi)
        }
    }

    //Metode addEdge ini menambahkan edge antara dua node(source dan dest) dalam graph
    public void addEdge(int source, int dest) { 
        adj[source].add(dest);
    }

    //Metode convert ini mengubah angka menjadi huruf
    public String convert(int s) {
        String alphabet[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        return alphabet[s];
    }

    public void dfs(int source) {
        Stack<Integer> stack = new Stack<>(); //Menyimpan node yang akan dikunjungi selama proses DFS
        stack.push(source); //Push vertex yang ada sekarang

        //Loop vertex yang ada di stack, lalu print vertex
        while (stack.empty() == false) {    
            source = stack.peek();  //Mengambil node yang berada diposisi teratas (tanpa menghapusnya)
            stack.pop();    //Menghapus node teratas
            if (visited[source] == false) { //Mengecek apakah node sudah dikunjungi atau belum
                System.out.print(convert(source) + " ");
                visited[source] = true; 
            }

            Iterator<Integer> it = adj[source].iterator();

            //Looping melalui tetangga
            //Kondisi ini mengecek apakah tetangga sudah dikunjungi
            //Jika bernilai true (tetangga belum dikunjungi), tetangga tersebut ditambahkan(push) ke dalam stack 
            while (it.hasNext()) {
                int v = it.next();
                if (!visited[v]) {
                    stack.push(v);
                }
            }
        }
    }

}
