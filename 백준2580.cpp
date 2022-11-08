#include <iostream>
#include <vector>
using namespace std;

vector<pair<int, int>> pa;
int sdocu[9][9];
int cnt;

bool checking(int row,int col) {
	int check[10] ={-1,};
	for (int i = 0; i < 9; ++i) {
		if (sdocu[row][i] == sdocu[row][col] && i != col) {
			return false;
		}
	}
	for (int i = 0; i < 9; ++i) {
		if (sdocu[i][col] == sdocu[row][col] && i != row) {
			return false;
		}
	}
	int a; int b;
	a = (row / 3) * 3;
	b = (col / 3) * 3;
	for (int i = a; i < a + 3; ++i) {
		for (int j = b; j < b + 3; ++j) {
			if (sdocu[i][j] == sdocu[row][col])
			{
				if (i != row && j != col) {
					return false;
				}
			}
		}
	}
	return true;
}

bool found;
void sol(int N) {

	if (cnt == N) {
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				cout << sdocu[i][j] << " ";
			}
			cout << "\n";
		}
		found = true;
		return;
	}
	for (int i = 1; i <= 9; ++i) {
		sdocu[pa[N].first][pa[N].second] = i;
		if (checking(pa[N].first, pa[N].second))
			sol(N + 1);
		if (found)
			return;
	}
	sdocu[pa[N].first][pa[N].second] = 0;
	return;
}


int main() {

	for (int i = 0; i < 9; ++i) {
		for (int j = 0; j < 9; ++j) {
			cin >> sdocu[i][j];
			if (sdocu[i][j] == 0) {
				pa.push_back({ i,j });
				cnt++;
			}
		}
	}
	sol(0);

}