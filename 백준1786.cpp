#include <iostream>
#include<vector>
#include <string>
using namespace std;

void failureFunction(vector<int>& f, string str2) {
	f[0] = 0;
	int i = 1; int j = 0;
	while (i < str2.size()) {
		if (str2[i] == str2[j]) {
			f[i] = j + 1;
			++i;
			++j;
		}
		else if (j > 0) {
			j = f[j - 1];
		}
		else {
			f[i] = 0;
			++i;
		}
	}
}

vector<int> KMP(string str1, string str2, vector<int> f) {
	int i = 0; int j = 0;
	vector<int> temp;
	while (i < str1.size()) {
		if (str1[i] == str2[j]) {
			if (j == str2.size() - 1) {
				temp.push_back(i - j+1);
			}
			++i;
			++j;
		}
		else if (j > 0) {
			j = f[j - 1];
		}
		else {
			++i;
		}
	}
	return temp;
}

int main() {
	string str1;
	string str2;
	getline(cin, str1);
	getline(cin, str2);
	vector<int> failure;
	for (int i = 0; i < str2.size(); ++i) {
		failure.push_back(0);
	}
	failureFunction(failure, str2);
	vector<int> res = KMP(str1, str2, failure);
	cout << res.size() << "\n";
	for (int i = 0; i < res.size(); ++i) {
		cout << res[i] << " ";
	}
}