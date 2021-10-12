#include<bits/stdc++.h>
using namespace std;

#define int long long

struct FenTree{
	int size;
	vector<int> f;
	void init(int n){
		size = n + 1;
		f.assign(size, 0);
	}
	void update(int idx, int v){
		while(idx < size){
			f[idx] += v;
			idx += idx&-idx;
		}
	}
	int sum(int idx){
		int ans = 0;
		while(idx > 0){
			ans += f[idx];
			idx -= idx&-idx;
		}
		return ans;
	}
	int sum(int l, int r){
		return sum(r) - sum(l - 1);
	}
};
void solve(){
	int n, q;
	cin>>n>>q;
	FenTree ft;
	ft.init(n);
	for(int i = 0; i < q; i++){
		int type;
		cin>>type;
		if(type == 1){
			//to change value at index idx by v
			int idx, v;
			cin>>idx>>v;
			ft.update(idx, v);
		}
		else{
			// find the sum of the range [l, r]
			int l, r;
			cin>>l>>r;
			cout<<ft.sum(l, r)<<'\n';
		}
	}
}

int32_t main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	int t = 1;
	//cin>>t;
	while(t--)
		solve();
	return 0;
}
