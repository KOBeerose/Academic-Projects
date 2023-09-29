class Solution:
    def numOfSubarrays(self, arr: list[int], k: int, threshold: int) -> int:
      c = 0
      elm_sum = sum(arr[:k])+arr[-1]-arr[k]
      for i in range(len(arr)-k):
        elm_sum += -arr[i-1]+arr[i+k]
        if elm_sum/k >= threshold:
          c+=1
      return c


arr = [11,13,17,23,29,31,7,5,2,3]
k = 3
threshold = 5
mysolution = Solution()
print(mysolution.numOfSubarrays(arr, k, threshold))
