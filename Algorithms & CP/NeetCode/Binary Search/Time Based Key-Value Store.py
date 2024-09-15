from collections import defaultdict

class TimeMap:

    def __init__(self):
        self.timeMap = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.timeMap[key].append((timestamp, value))
        self.previous_tsmp = timestamp
        return None

    def get(self, key: str, timestamp: int) -> str:
        if key in self.timeMap:
            result = None
            if self.previous_tsmp <= timestamp:
                return self.timeMap[key][-1][1]
            l, r = 0, len(self.timeMap[key])-1
            while l <= r:
                mid = (r + l) // 2
                if timestamp < self.timeMap[key][mid][0]:
                    r = mid - 1
                else:
                    result = self.timeMap[key][mid][1]
                    l = mid + 1
            return result if result else ""
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

