#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    vector<int> mid;
    vector<int>* check1 = new vector<int>[id_list.size()];
    vector<string> user; vector<string> decl;

    for (int i = 0; i < id_list.size(); ++i) {
        answer.push_back(0);
        mid.push_back(0);
    }
    for (int i = 0; i < report.size(); ++i) {
        string a = report[i].substr(0, report[i].find(" "));
        string b = report[i].substr(report[i].find(" ") + 1, report[i].length());
        int idx1 = 0; int idx2 = 0;
        for (int j = 0; j < id_list.size(); ++j) {
            if (a == id_list[j]) {
                idx1 = j;
            }
        }
        for (int j = 0; j < id_list.size(); ++j) {
            if (b == id_list[j]) {
                idx2 = j;
            }
        }
        for (int i = 0; i < check1[idx2].size(); ++i) {
            if (check1[idx2][i] == idx1) {
                idx1 = -1;
            }
        }
        if (idx1 != -1) {
            check1[idx2].push_back(idx1);
        }
        
    }
    
    for (int i = 0; i < id_list.size(); ++i) {
        if (check1[i].size() >= k) {
            for (int j = 0; j < check1[i].size(); ++j) {
                answer[check1[i][j]]++;
            }
        }
    }
    return answer;
}

int main() {
    vector<string> a = { "muzi", "frodo", "apeach", "neo" };
    vector<string> report = { "muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi" };
    int k = 2;
    vector<int> answer = solution(a, report, k);
    for (int i = 0; i < answer.size(); ++i) {
        cout << answer[i] << " ";
    }
}
