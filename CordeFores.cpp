#include <iostream>
#include <vector>
#include <map>
using namespace std;


int main() {
	int n = 0;
	cin >> n;
	int k = 0;
	string str;
	for (int i = 0; i < n; ++i) {
		cin >> k;
		vector<string> v(k);
		vector<int> arr;
		map <string, int> mp;
		string a;
		string b;
		for (int j = 0; j < k; ++j) {
			cin >> v[j];
			mp[v[j]]++;
			arr.push_back(0);
		}
		for (int i = 0; i < v.size(); ++i) {
			for (int j = 0; j < v[i].size(); ++j) {
				a = v[i].substr(0, j);
				b = v[i].substr(j, v[i].size());
				if (mp.find(a) != mp.end() && mp.find(b) != mp.end()) {
					arr[i] = 1;
				}
			}
		}
		for (int j = 0; j < k; ++j) {
			cout << arr[j];
		}
		cout << "\n";
	}
}