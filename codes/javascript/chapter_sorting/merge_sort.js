/**
 * File: quick_sort.js
 * Created Time: 2022-12-01
 * Author: IsChristina (christinaxia77@foxmail.com)
 */

/**
* 合并左子数组和右子数组
* 左子数组区间 [left, mid]
* 右子数组区间 [mid + 1, right]
*/
function merge(nums, left, mid, right) {
    // 初始化辅助数组
    let tmp = nums.slice(left, right + 1);   
    // 左子数组的起始索引和结束索引  
    let leftStart = left - left, leftEnd = mid - left;
    // 右子数组的起始索引和结束索引       
    let rightStart = mid + 1 - left, rightEnd = right - left;
    // i, j 分别指向左子数组、右子数组的首元素
    let i = leftStart, j = rightStart;                
    // 通过覆盖原数组 nums 来合并左子数组和右子数组
    for (let k = left; k <= right; k++) {
        // 若 “左子数组已全部合并完”，则选取右子数组元素，并且 j++
        if (i > leftEnd) {
            nums[k] = tmp[j++];
        // 否则，若 “右子数组已全部合并完” 或 “左子数组元素 < 右子数组元素”，则选取左子数组元素，并且 i++
        } else if (j > rightEnd || tmp[i] <= tmp[j]) {
            nums[k] = tmp[i++];
        // 否则，若 “左子数组元素 > 右子数组元素”，则选取右子数组元素，并且 j++
        } else {
            nums[k] = tmp[j++];
        }
    }
}

/* 归并排序 */
function mergeSort(nums, left, right) {
    // 终止条件
    if (left >= right) return;       // 当子数组长度为 1 时终止递归
    // 划分阶段
    let mid = Math.floor((left + right) / 2);    // 计算中点
    mergeSort(nums, left, mid);      // 递归左子数组
    mergeSort(nums, mid + 1, right); // 递归右子数组
    // 合并阶段
    merge(nums, left, mid, right);
}

/* Driver Code */
var nums = [ 7, 3, 2, 6, 0, 1, 5, 4 ]
mergeSort(nums, 0, nums.length - 1)
console.log("归并排序完成后 nums =", nums)
