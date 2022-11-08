#include <iostream>
#include <vector>
using namespace std;

const int MAX = 1000000;
long long tree[MAX * 4 + 100];
long long lazy[MAX * 4 + 100];
long long pro[MAX + 10];

void init(long long node, long long s, long long e) {
	if (s == e)
	{
		tree[node] = pro[s];
		return;
	}
	int mid = (s + e) / 2;
	init(node * 2, s, mid);
	init(node * 2 + 1, mid + 1, e);
	tree[node] = tree[node * 2] + tree[node * 2 + 1];
}

void update(long long node, long long s, long long e, long long index, long long x) {
	if (index < s || e < index) return;
	if (s == e) {
		tree[node] = x;
		return;
	}
	int mid = (s + e) / 2;
	update(node * 2, s, mid, index, x);
	update(node * 2 + 1, mid + 1, e, index, x);
	tree[node] = tree[node * 2] + tree[node * 2 + 1];

}

long long out(long long node, long long s, long long e, long long l, long long r) {
	if (r < s || e < l) return 0;
	if (l <= s && e <= r) return tree[node];
	int mid = (s + e) / 2;
	return out(node * 2, s, mid, l, r) + out(node * 2 + 1, mid + 1, e, l, r);
}

int main() {
	long long n = 0; long long m = 0; long long k = 0;
	cin >> n >> m >> k;
	long long num = 0;
	for (int i = 1; i <= n; ++i) {
		cin >> num;
		pro[i] = num;
	}
	init(1, 1, n);
	long long a; long long b; long long c;
	long long res;
	for (int i = 0; i < m + k; ++i) {
		cin >> a >> b >> c;
		if (a == 1) {
			update(1, 1, n, b, c);
			pro[b] = c;
		}
		else {
			res = out(1, 1, n, b, c);
			cout << res << "\n";
		}
	}
}