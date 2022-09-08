package baekjoon_study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// Link : 
// 1. LinkedList�� �̿��ϴ� �ð��ʰ� �߻���.
// 2. �� ���� Stack�� �̿��ϸ� ������ �ذ� ����(Ŀ�� ���� ������ ����1, ���� �������� ����2�� �̿�). ���� ���� �ð��� O(1)��
public class Baekjoon_No_1406 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		char[] charArr = str.toCharArray();
		int N = Integer.parseInt(br.readLine());
		
		Stack<Character> left = new Stack<>();			// Ŀ�� ���� ���� 
		Stack<Character> right = new Stack<>();			// Ŀ�� ���� ������
		
		// �Է¹��� ���ĺ����� ���� ���ÿ� �ֱ�
		for(char c : charArr) {
			left.push(c);
		}
		
		// ������ ����ŭ �ݺ�
		for(int i=0; i<N; i++) {
			charArr = br.readLine().toCharArray();
			
			switch(charArr[0]) {
			// Ŀ���� �������� �ű�(�� �����̸� ����) : ���� ���ÿ��� �ϳ� ���� ������ �������� �ű� 
			case 'L':
				if(!left.isEmpty()) {
					right.push(left.pop());
				}
				break;
				
			// Ŀ���� ���������� �ű�(�� �������̸� ����) : ������ ���ÿ��� �ϳ� ���� ���� �������� �ű�
			case 'D':
				if(!right.isEmpty()) {
					left.push(right.pop());
				}
				break;
				
			// Ŀ�� ���ʿ� �ִ� ���� ����(Ŀ���� �� �����̸� ����) : ���� ���ÿ��� �ϳ� ����
			case 'B':
				if(!left.isEmpty()) {
					left.pop();
				}
				break;
				
			// ���ڸ� Ŀ�� ���ʿ� �߰�	
			case 'P':
				left.push(charArr[2]);
				break;
			}
		}
		
		// ���� ���ÿ� �ִ� ���ĺ����� ������ �������� �ű� (FILO �̿�)
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		
		// ������ ���ÿ��� ���ĺ��� �ϳ��� ���鼭 ���
		while(!right.isEmpty()) {
			bw.write(right.pop());
		}
		
		bw.flush();
		bw.close(); 
	}

}
