package baekjoon.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// Link : https://www.acmicpc.net/problem/10816
public class Baekjoon_No_10816{
	// N: ������ �ִ� ī���� ��, M: ã�� ī���� ��
	public static int N, M;
	
	// HashMap�� �̿��ؼ� Ǯ�̿���
	public static HashMap<Integer, Integer> resultMap = new HashMap<>();;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			// ���� �ϳ��� �޾Ƽ�
			int num = Integer.parseInt(st.nextToken());
			
			// resultMap�� �ش� ���ڰ� ������ 1�־��ְ�
			if(resultMap.get(num) == null) {
				resultMap.put(num, 1);
			}
			// ������, ���� ��Ŵ
			else {
				resultMap.put(num, resultMap.get(num)+1);
			}
		}
		
		M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb =new StringBuilder();
		
		// �ش� ���ڰ� �� �� ����ִ� �� Ȯ��
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			int cnt;
			// �ش� ���ڰ� �ƿ� ������ 0
			if(resultMap.get(num) == null) {
				cnt = 0;
			// ������ �״�� ���
			}else {
				cnt = resultMap.get(num);
			}
			sb.append(cnt + " ");
		}
		
		System.out.print(sb.toString());
	}
}