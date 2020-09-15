package com.yny.testcode

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

/**
 * LeetCode
 *
 * @author nianyi.yang
 * @date 2020-01-20 19:29
 */
class LeetCodeTest {

    @Test
    fun addTwoNumber() {
        val addTwoNumber = AddTwoNumber()
        val result = addTwoNumber.twoSum(
            nums = intArrayOf(2, 7, 11, 15),
            target = 9
        )

        //使用hamcrest进行assert，直观，易读
        assertThat(result, `is`(intArrayOf(0, 1)))
    }

    @Test
    fun orangesRotting() {
        val breadthFirstSearch = BreadthFirstSearch()
        val result = breadthFirstSearch.orangesRotting(
            arrayOf(
                intArrayOf(1, 2)
            )
        )

        assertThat(result, `is`(1))
    }

    @Test
    fun findContinuousSequence() {
        val slidingWindow = SlidingWindow()
        val result = slidingWindow.findContinuousSequence(9)

        assertThat(
            result, `is`(
                arrayOf(
                    intArrayOf(2, 3, 4),
                    intArrayOf(4, 5)
                )
            )
        )
    }

    @Test
    fun diameterOfBinaryTree() {

        val tree = BinaryTree.TreeNode(1)
        tree.left = BinaryTree.TreeNode(2)
        tree.right = BinaryTree.TreeNode(3)
        tree.left!!.left = BinaryTree.TreeNode(4)
        tree.left!!.right = BinaryTree.TreeNode(5)

        val binaryTree = BinaryTree()
        val result = binaryTree.diameterOfBinaryTree(tree)

        assertThat(result, `is`(3))
    }

    @Test
    fun majorityElement() {
        val exampleArray = ExampleArray()
        val result = exampleArray.majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2))

        assertThat(result, `is`(3))
    }

    @Test
    fun maxSubArray() {
        val exampleArray = ExampleArray()
        val result = exampleArray.maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))

        assertThat(result, `is`(6))
    }

    @Test
    fun isUgly() {
        val exampleNumber = ExampleNumber()
        val result = exampleNumber.isUgly(1)

        assertThat(result, `is`(true))
    }

    @Test
    fun countCharacters() {
        val exampleString = ExampleString()
        val result = exampleString.countCharacters(
            arrayOf(
                "skwgxuuuumkfurejmqrbipvlavdrozjyxhagbwetabjwevfsegqfpllgafm",
                "ufvpzzgpswnk",
                "tcouxmlrnfyoxvkeglchhryykmdvgvdxpookbtiyhuthoqsnqbowewpfgbcy",
                "qwpttmxzazkkfqqtrnkaejifligdvgnyvtmppjbkeuqryxzqyegttvhzolpztvigxygzvsppurijaekb",
                "vbtvbheurzbglzljczmziitkbmtoybiwhoyfrsxvfveaxchebjdzdnnispzwbrgrbcdaistps"
            ),
            "avyteswqppomeojxoybotzriuvxolmllevluauwb"
        )

        assertThat(result, `is`(0))
    }

    @Test
    fun isRectangleOverlap() {
        val exampleRect = ExampleRect()
        val result = exampleRect.isRectangleOverlap(
            intArrayOf(0, 0, 1, 1),
            intArrayOf(1, 0, 2, 1)
        )

        assertThat(result, `is`(false))
    }

    @Test
    fun longestPalindrome() {
        val exampleString = ExampleString()
        val result =
            exampleString.longestPalindrome(
                "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"
            )

        assertThat(result, `is`(983))
    }

    @Test
    fun maxProfit() {
        val stock = Stock()
        val result = stock.maxProfit(intArrayOf(3, 2, 6, 5, 0, 3))

        assertThat(result, `is`(4))
    }

    @Test
    fun hasGroupsSizeX() {
        val exampleArray = ExampleArray()
        val result = exampleArray.hasGroupsSizeX(
            intArrayOf(
                1,
                1,
                1,
                1,
                1,
                1,
                2,
                2,
                2,
                2,
                2,
                2,
                2,
                2,
                2,
                3,
                3,
                3,
                3,
                3,
                3,
                3,
                3
            )
        )

        assertThat(result, `is`(false))
    }

    @Test
    fun gameOfLife() {
        val exampleArray = ExampleArray()
        val result = exampleArray.gameOfLife(
            arrayOf(
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 1),
                intArrayOf(1, 1, 1),
                intArrayOf(0, 0, 0)
            )
        )

        assertThat(
            result, `is`(
                arrayOf(
                    intArrayOf(0, 0, 0),
                    intArrayOf(1, 0, 1),
                    intArrayOf(0, 1, 1),
                    intArrayOf(0, 1, 0)
                )
            )
        )
    }

    @Test
    fun testLFUCache() {
        val cache = LFUCache(2)
        cache.put(2, 1)
        cache.put(2, 2)
        assertThat(cache.get(2), `is`(2))
        cache.put(1, 1)
        cache.put(4, 1)
        assertThat(cache.get(2), `is`(2))

//        cache.put(3, 1)
//        cache.put(2, 1)
//        cache.put(2, 2)
//        cache.put(4, 4)
//        assertThat(cache.get(2), `is`(2))

//        cache.put(0, 0)
//        assertThat(cache.get(0), `is`(-1))
    }

    @Test
    fun rotate() {
        val exampleMatrix = ExampleMatrix()
        val result = exampleMatrix.rotate(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9)
            )
        )

        assertThat(
            result, `is`(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                )
            )
        )

    }

    @Test
    fun reverseWords() {
        val exampleString = ExampleString()
        val result = exampleString.reverseWords("the sky is blue")

        assertThat(result, `is`("blue is sky the"))
    }

    @Test
    fun threeSum() {
        val exampleNumber = ExampleNumber()
        val result = exampleNumber.threeSum(intArrayOf(-1, 0, 1, 2, -1, 4))

        assertThat(
            result, `is`(
                listOf(
                    listOf(-1, -1, 2),
                    listOf(-1, 0, 1)
                )
            )
        )
    }

    @Test
    fun letterCombinations() {
        val exampleNumber = ExampleNumber()
        val result = exampleNumber.letterCombinations("23")

        assertThat(
            result, `is`(
                listOf(
                    "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
                )
            )
        )
    }

    @Test
    fun removeNthFromEnd() {
        val head = LinkList.ListNode(1)
//        head.next = LinkList.ListNode(2)
//        head.next!!.next = LinkList.ListNode(3)
//        head.next!!.next!!.next = LinkList.ListNode(4)
//        head.next!!.next!!.next!!.next = LinkList.ListNode(5)

        val linkList = LinkList()
        val result = linkList.removeNthFromEnd(head, 1)

        assertThat(result, `is`(head))
    }

    @Test
    fun reverseList() {
        val head = LinkList.ListNode(1)
        head.next = LinkList.ListNode(2)
        head.next!!.next = LinkList.ListNode(3)
        head.next!!.next!!.next = LinkList.ListNode(4)
        head.next!!.next!!.next!!.next = LinkList.ListNode(5)

        val result = LinkList().reverseList(head)

        val compare = LinkList.ListNode(5)
        compare.next = LinkList.ListNode(4)
        compare.next!!.next = LinkList.ListNode(3)
        compare.next!!.next!!.next = LinkList.ListNode(2)
        compare.next!!.next!!.next!!.next = LinkList.ListNode(1)

        // assertThat(result, `is`(equals(compare)))
    }
}