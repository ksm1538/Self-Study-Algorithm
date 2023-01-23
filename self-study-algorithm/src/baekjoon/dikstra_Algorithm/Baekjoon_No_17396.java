package baekjoon.dikstra_Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_No_17396 {

	public static class Node implements Comparable<Node>{
		int pos;
		long cost;
		
		public Node(int pos, long cost) {
			this.pos = pos;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node other){
			if(this.cost < other.cost) 
				return -1;
			else 
				return 1;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<ArrayList<Node>> map = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());		// �б��� ��
		int M = Integer.parseInt(st.nextToken());		// �б����� �մ� ����� ��
		
		boolean[] sight = new boolean[N];
		boolean[] visited = new boolean[N];
		long[] d = new long[N];
		
		final long INF = Long.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());	// �þ� ����. 0: �þ�X, 1: �þ�O
			if(num == 1)
				sight[i] = true;
			else
				sight[i] = false;
			
			map.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
		
			int posA = Integer.parseInt(st.nextToken());
			int posB = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());		// �ɸ��� �ð�

			// ����� �̵� ����
			map.get(posA).add(new Node(posB, cost));
			map.get(posB).add(new Node(posA, cost));
		}
		
		// 0�� °���� ���(è�Ǿ���ġ)
		Arrays.fill(d, INF);
		d[0] = 0 ;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int pos = now.pos;
			long cost = now.cost;
		
			// �湮�� ���� ��湮 X
			if(visited[pos]) continue;
            visited[pos] = true;
			
			for(int i=0; i<map.get(pos).size(); i++) {
				Node next = map.get(pos).get(i);
				int nextPos = next.pos;
				long nextCost = next.cost;
								
				if((sight[nextPos] == true && nextPos != (N-1)))
					continue;
					
				long sum = cost + nextCost;
				if(d[nextPos] > sum) {
					d[nextPos] = sum;
					pq.offer(new Node(nextPos, sum));
				}
			}
		}
		
		if(d[N-1] == INF)
			System.out.println(-1);
		else
			System.out.println(d[N-1]);
	}

}