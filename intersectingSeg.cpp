#include<bits/stdc++.h>
using namespace std;
#define int long long
#define END '\n'

struct SegTree{
	int size;
	vector<int> f;
	void init(int n){
		size = 1;
		while(size < n)
			size *= 2;
		f.assign(2 * size, 0);
	}
	void set(int i, int v, int x, int lx, int rx){
		if(rx - lx == 1){
			f[x] = v;
			return;
		}
		int m = (lx + rx)/2;
		if(i < m)
			set(i, v, 2 * x + 1, lx, m);
		else
			set(i, v, 2 * x + 2, m, rx);
		f[x] = f[2 * x + 1] + f[2 * x + 2];
	}
	void set(int i, int v){
		set(i, v, 0, 0, size);
	}
	int get(int l, int r, int x, int lx, int rx){
		if(lx >= r || l >= rx) return 0;
		else if(lx >= l && rx <= r) return f[x];
		int m = (lx + rx)/2;
		return get(l, r, 2 * x + 1, lx, m) + get(l, r, 2 * x + 2, m, rx);
	}
	int get(int i){
		return get(i, size, 0, 0, size);
	}
};

void solve(){
	int n, x;
	cin>>n;
	vector<int> a(2 * n), v(n + 1, -1), ans(n + 1, 0);
	SegTree st;
	st.init(2 * n);
	for(int i = 0; i < 2 * n; i++){
		cin>>a[i];
		x = a[i];
		if(v[x] == -1){
			v[x] = i;
			st.set(v[x], 1);
		}
		else{
			st.set(v[x], 0);
			ans[x] += st.get(v[x]);
		}
	}
	v.assign(n + 1, -1);
	for(int i = 0; i < 2 * n; i++){
		x = a[2 * n - 1 - i];
		if(v[x] == -1){
			v[x] = i;
			st.set(v[x], 1);
		}
		else{
			st.set(v[x], 0);
			ans[x] += st.get(v[x]);
		}
	}
	for(int i = 1; i <= n; i++)
		cout<<ans[i]<<" ";
}

int32_t main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	int t = 1;
	while(t--)
		solve();
	return 0;
}
