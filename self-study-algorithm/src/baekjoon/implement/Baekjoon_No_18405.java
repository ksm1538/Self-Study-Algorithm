package baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_No_18405 {

	// N : ������� ũ��, K : ���� ���� ���̷����� ��ȣ 
	public static int N, K;
	
	// ��
	public static int[][] map;
	
	// �����¿� ������ �� ���� �迭��
	public static int[] xmove = {-1,1,0,0};
	public static int[] ymove = {0,0,-1,1};

	// ���̷����� ��ġ�� ���� ť
	public static Queue<Virus> q = new LinkedList<>();
	
	// ���̷��� Ŭ���� 
	public static class Virus implements Comparable<Virus>{
		int y;
		int x;
		int rank;
		
		public Virus(int y, int x, int rank) {
			this.y = y;
			this.x = x;
			this.rank = rank;
		}

		@Override
		public int compareTo(Virus o) {
			// TODO Auto-generated method stub
			if(this.rank < o.rank) {
				return -1;
			}
			else {
				return 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		// �켱����ť�� �־ ���� ���̷������� ���ĵǵ��� ��
		PriorityQueue<Virus> pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				
				// ���̷����� ���� �־���
				if(num != 0) {
					pq.offer(new Virus(i, j, num));
				}
			}
		}
		
		// �켱���� ť�� �ִ� �����(���ĵǾ�����)�� �Ϲ� ť�� ����
		while(!pq.isEmpty()) {
			Virus v = pq.poll();
			q.offer(v);
		}
		
		st = new StringTokenizer(br.readLine());
		int endTime = Integer.parseInt(st.nextToken());
		int endY = Integer.parseInt(st.nextToken()) - 1; 	
		int endX = Integer.parseInt(st.nextToken()) - 1;
		
		// �־��� �ʸ�ŭ �ݺ�
		for(int i=0; i<endTime; i++) {
			Queue<Virus> q2 = new LinkedList<>();
			
			// q�� �ִ� �� q2�� �ű��
			while(!q.isEmpty()) {
				Virus v = q.poll();
				q2.offer(v);
			}
			
			// q2�� �ִ� ���� ��� Ž��
			while(!q2.isEmpty()) {
				// q2���� ���� ���̷�����
				Virus v = q2.poll();
				
				// �����¿� Ȯ���Ű��
				Spread(v);
			}
		}
		
		// ��� ���
		System.out.println(map[endY][endX]);
	}
	
	// ���̷��� Ȯ��
	public static void Spread(Virus v) {
		// �����¿� Ž��
		for(int i=0; i<4; i++) {
			int tempY = v.y + ymove[i];
			int tempX = v.x + xmove[i];
			
			// ���� ������ ����� ����
			if(tempY < 0 || tempY >= N || tempX < 0 || tempX >= N) {
				continue;
			}else {
				int vRank = map[tempY][tempX];
				
				// �̵��� ���� ���̷����� ���� ���ٸ�
				if(vRank == 0) {
					// ���̷��� ��Ʈ����
					map[tempY][tempX] = v.rank;
					
					// q���ٰ� �ֱ�
					q.offer(new Virus(tempY, tempX, v.rank));
				}
			}
		}
	}

}