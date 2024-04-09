#include<iostream>
#include<algorithm>
#include<string>
using namespace std;

int value[27];

int main() {

	for (int i = 1; i <= 26; i++) {
		value[i] = i;
	}

	int N, X;
	cin >> N >> X;

	string str;

	int v = 26;

	int tempN = N;
	while (X > 0 && v > 0) {
		if (X >= v) {
			str += (char)('A' + v - 1);
			X -= v;
			tempN--;
			
			if (tempN == 0 && X > 0) {
				str = "!";
				break;
			}
		}
		else {
			v--;
		}
	}

	if (str == "!") {
		cout << str << "\n";
		return 0;
	}

	//첫 번째 문자에서 A 추가하고 빼기
	reverse(str.begin(),str.end());

	int idx = 0;
	int cnt = 0;
	int n = str.length();

	//앞 문자열부터 A로 변환
	for (int i = 0; i < str.length(); i++) {
		if (cnt + n == N)break;
		if (str[i] == 'A')continue;

		if (cnt + (int)(str[i] - 'A') + n <= N) {
			cnt += (str[i] - 'A');
			str[i] = 'A';
		}
		else {
			int temp = N - cnt - n;
			cnt += temp;
			str[i] -= temp;
		}
		
	}

	if (cnt +n < N) {
		cout << "!" << "\n";
	}
	else {
		for (int i = 1; i <= cnt; i++) {
			cout << "A";
		}
		cout << str << "\n";
	}

	return 0;
}