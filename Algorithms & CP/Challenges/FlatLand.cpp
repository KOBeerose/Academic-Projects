#include <bits/stdc++.h>
#define pb push_back
using namespace std;
const int MAXL = 20;

vector<vector<int>> g,par;
vector<int> lvl;
void init(int N){
    g.clear();g.resize(N);
    lvl.clear();lvl.resize(N,0);
    par.clear();par.resize(N,vector<int>(MAXL,0));
}
void dfs(int u){
    for(auto v:g[u])if(par[u][0]!=v){
        lvl[v]= 1+lvl[u];
        par[v][0] = u;
        dfs(v);
    }
}
int lca(int a,int b){
    if(lvl[a]<lvl[b])swap(a,b);
    for(int i=MAXL-1;i>=0;i--){
        if(lvl[par[a][i]] >= lvl[b])
            a = par[a][i];
    }
    if(a==b)return a;
    for(int i=MAXL-1;i>=0;i--){
        if(par[a][i]!=par[b][i]){
            a = par[a][i];
            b = par[b][i];
        }
    }
    return par[a][0];
}
int main(){
    freopen("fireworks.in","r",stdin);
    int tc;scanf("%d",&tc);
    while(tc--){
        int N;scanf("%d",&N);init(N);
        int K;scanf("%d",&K);init(K);
        vector<int> arr;
        for(int i=1;i<N;i++){
            int u,v;scanf("%d %d",&u,&v);u--;v--;
            g[u].pb(v);g[v].pb(u);arr.pb(v);
        }
        dfs(0);
        for(int i=1;i<MAXL;i++)
            for(int j=1;j<N;j++)
                par[j][i] = par[par[j][i-1]][i-1];
        int a = 0,b = 0,ans = 0;
        for(auto i:arr){
            int x = lca(a,i),y = lca(b,i);
            int d1 = lvl[a]+lvl[i]-2*lvl[x],
                d2 = lvl[b]+lvl[i]-2*lvl[y];
            if(ans < d1 || ans < d2){
                if(d1>d2) b = i;
                else a = i,d1=d2;
                ans = d1;
            }
            printf("%d\n",1+ans);
        }
    }
}
