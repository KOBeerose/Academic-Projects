from collections import defaultdict

class TimeMap:

    def __init__(self):
        self.map_time = defaultdict(dict)
        self.prev_timestamps = []
        return None

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.map_time[key][timestamp] = value
        self.prev_timestamps.append(timestamp)
        return None

    def get(self, key: str, timestamp: int) -> str:
        
        def get_pre_timestamp(timestamp: int) -> int:
            stamp_list = self.prev_timestamps
            l, r = 0, len(stamp_list)-1
            while l <= r:
                
                mid = (l+r)//2
                if timestamp < stamp_list[mid] :
                    r = mid - 1
                else:
                    l = mid + 1
            res = stamp_list[r] if stamp_list[r]<timestamp else -1
            return res
            
        prev_timestamp = get_pre_timestamp(timestamp)
        map_time = self.map_time
        if key in map_time:
            if timestamp in map_time[key]:
                return map_time[key][timestamp]
            elif (self.prev_timestamps) and prev_timestamp in map_time[key]:
                return map_time[key][prev_timestamp]
            else:
                return ""
        else:
            return ""

input_list = ["TimeMap", "set", ["test", "one", 10], "set", ["test", "two", 20], "set", ["test", "three", 30], "get", ["test", 15], "get", ["test", 25], "get", ["test", 35]]

output_list = []
i = 0
while i < len(input_list):
    if input_list[i] == "TimeMap":
        timeMap = TimeMap()
        output_list.append(None)
    elif input_list[i] == "set":
        key, value, timestamp = input_list[i+1]
        output_list.append(timeMap.set(key, value, timestamp))
        i+= 1
        
    elif input_list[i] == "get":
        key, timestamp = input_list[i+1]
        output_list.append(timeMap.get(key, timestamp))
        i+= 1
    else:
        print("there is an error in your input_list")
        break
    i+=1
    
print(output_list)

