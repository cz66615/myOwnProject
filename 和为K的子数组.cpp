int subarraySum(vector<int>& nums, int k) {
        int count = 0, pre = 0;
        unordered_map<int, int> mp;
        mp[0] = 1;
        for (auto& x:nums) {
            pre += x;
            if (mp.find(pre - k) != mp.end()) {
                count += mp[pre - k];
            }
            mp[pre]++;
        }
        return count;
    }
