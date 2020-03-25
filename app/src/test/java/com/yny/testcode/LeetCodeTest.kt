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
}