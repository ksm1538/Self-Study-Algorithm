package baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_No_16234 {

	public static int N, L, R;
	
	public static int[][] map;
	public static boolean[][] visited;
	
	public static int[][] sector;
	public static int sectorCount = 0;
	public static boolean flag = false;
	
	public static int[] xmove = {1,-1,0,0};
	public static int[] ymove = {0,0,1,-1};
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		sector = new int[N][N];
				
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		
		// ���� �ݺ�
		while(true) {
			sectorCount = 0;
			visited = new boolean[N][N];
			sector = new int[N][N];
			flag = false;
			
			// 1. ���� ã��
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					if(visited[i][j] == false) {
						sectorCount++;
						DFS(i,j);
					}
				}
			}
			
			// ���漱�� ���� ���� ������ �ݺ� ����
			if(flag == false) {
				break;
			}
			cnt++;
			
			// 2. ������ �α� �� ��� �غ�
			// �迭 ���� : tempSum[����][0:�����α����հ�, 1:������ �̷�³����� ��, 2:��հ�]
			int[][] tempSum = new int[sectorCount+1][3];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					int nowSector = sector[i][j];
					if(nowSector != 0) {
						tempSum[nowSector][0] += map[i][j];
						tempSum[nowSector][1]++;
					}
				}
			}
			
			// 3. �� ������ �α� ��� �� ���ϱ�
			for(int i=0; i<tempSum.length; i++) {
				if(tempSum[i][0] != 0) {
					tempSum[i][2] = tempSum[i][0] / tempSum[i][1];
				}
			}
			
			// 4. �ش� ������ ��� �� �־��ֱ�
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					
					int nowSector = sector[i][j];
					if(nowSector != 0) {
						map[i][j] = tempSum[nowSector][2];
					}
				}
			}
		}
		
		System.out.println(cnt);	// ��� ���
	}
	
	// DFS�� �̿��ؼ� ���� ã��
	public static void DFS(int y, int x) {
		visited[y][x] = true;		// �ش� ĭ�� ���;߸� �湮 üũ��.
		
		for(int k=0; k<4; k++) {
			int tempY = y+ymove[k];
			int tempX = x+xmove[k];
			
			
			// ���� ������ ����ٸ�
			if(tempY < 0 || tempY >= N || tempX < 0 || tempX >= N) {
				continue;
			}
			else {
				// �� ������ ���̸� �������� ����
				int difference = Math.abs(map[y][x] - map[tempY][tempX]);
				
				// ���õ� ���� ���� ���� && �湮���� ���� ���̶��
				if(difference >= L && difference <= R && visited[tempY][tempX] == false) {
					
					// ������ �����ְ�
					sector[y][x] = sectorCount;
					sector[tempY][tempX] = sectorCount;
					
					// flag�� true�� ����(���漱�� ���� ���� �ִ�)
					flag = true;
					
					// ���ȣ��
					DFS(tempY, tempX);
				}
			}
		}
	}
}