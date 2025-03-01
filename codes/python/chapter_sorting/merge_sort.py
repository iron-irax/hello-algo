'''
File: merge_sort.py
Created Time: 2022-11-25
Author: timi (xisunyy@163.com)
'''

import sys, os.path as osp
sys.path.append(osp.dirname(osp.dirname(osp.abspath(__file__))))
from include import *

"""
合并左子数组和右子数组
左子数组区间 [left, mid]
右子数组区间 [mid + 1, right]
"""
def merge(nums, left, mid, right):
    # 初始化辅助数组 借助 copy模块
    tmp = nums[left:right + 1]
    # 左子数组的起始索引和结束索引
    left_start, left_end = left - left, mid - left
    # 右子数组的起始索引和结束索引
    right_start, right_end = mid + 1 - left, right - left
    # i, j 分别指向左子数组、右子数组的首元素
    i, j = left_start, right_start
    # 通过覆盖原数组 nums 来合并左子数组和右子数组
    for k in range(left, right + 1):
        # 若 “左子数组已全部合并完”，则选取右子数组元素，并且 j++
        if i > left_end:
            nums[k] = tmp[j]
            j += 1
        # 否则，若 “右子数组已全部合并完” 或 “左子数组元素 < 右子数组元素”，则选取左子数组元素，并且 i++
        elif j > right_end or tmp[i] <= tmp[j]:
            nums[k] = tmp[i]
            i += 1
        # 否则，若 “左子数组元素 > 右子数组元素”，则选取右子数组元素，并且 j++
        else:
            nums[k] = tmp[j]
            j += 1

""" 归并排序 """
def merge_sort(nums, left, right):
    # 终止条件
    if left >= right:
        return                        # 当子数组长度为 1 时终止递归
    # 划分阶段
    mid = (left + right) // 2         # 计算中点
    merge_sort(nums, left, mid)       # 递归左子数组
    merge_sort(nums, mid + 1, right)  # 递归右子数组
    # 合并阶段
    merge(nums, left, mid, right)


""" Driver Code """
if __name__ == '__main__':
    nums = [ 7, 3, 2, 6, 0, 1, 5, 4 ]
    merge_sort(nums, 0, len(nums) - 1)
    print("归并排序完成后 nums =", nums)
