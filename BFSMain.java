public class BFSMain {
    public static void main(String[] args) {
        BFSTraversal graf = new BFSTraversal(10);

        //Asumsikan A = 0

        graf.addEdge(0, 1);
        graf.addEdge(0, 3);
        graf.addEdge(0, 4);

        graf.addEdge(3, 6);

        graf.addEdge(6, 7);

        graf.addEdge(7, 8);

        graf.addEdge(8, 5);

        graf.addEdge(5, 2);

        graf.addEdge(2, 1);

        graf.addEdge(1, 4);

        graf.addEdge(4, 7);
        graf.addEdge(4, 5);

        graf.addEdge(5, 7);

        System.out.println("BFS untuk graph (mulai dari A):");
        graf.bfs(0);
        
        System.out.println();

        graf.getAdj();
    }
}

//Hasil dari eksekusi kode ini akan menampilkan urutan kunjungan node pada graph menggunakan BFS 