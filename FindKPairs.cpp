class FindKPairs {
public:
    int findPairsOptimised(vector<int>& nums, int k) {
        int count=0;
        std::map<int, int> m;
        pair <map<int, int>::iterator, bool> ptr;
        for (int i = 0; i < nums.size(); i++) {
             ptr = m.insert( pair<int, int>(nums[i], 1) );
            if(!ptr.second) {

                if(m.find(nums[i]) != m.end()){
                m[nums[i]] = m.find(nums[i])->second + 1;
                }

            }
        }


        for (std::map<int, int>::iterator i = m.begin(); i != m.end(); ++i){
          cout << i->first <<":"<< i->second<<  endl;
}
         for (std::map<int, int>::iterator i = m.begin(); i != m.end(); ++i){
            if(k == 0 && i->second > 1) {
                             count++;
                        }
            else if(k > 0 && m.find(i->first + k)  != m.end()){
                count++;
         }
         }






        return count;

    }
public:
    int findPairs(vector<int>& nums, int k) {
        int count=0;
        set<int> s;
        std::sort (nums.begin(), nums.end());
        for (int i = 0; i < nums.size(); i++) {
                        cout<<nums[i]<<endl;
                    for (int j = i+1; j < nums.size(); j++) {
                        if((nums[i] - nums[j] >= 0 && nums[i] - nums[j]  == k)  || (nums[j] - nums[i] >= 0 && nums[j] - nums[i] == k)){
                        if(!s.count(nums[j])) {
                         s.insert( nums[j] );
                            count++;
                        }
}
                    }

        }

        return count;

    }
};
