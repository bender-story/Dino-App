package com.rahul.dino.core.utils

import com.rahul.dino.core.BaseTest
import org.junit.Assert
import org.junit.Test

class StringExtTest : BaseTest() {
    @Test
    fun `filterEmpty should give empty string if value is null`() {
        var value: String? = null
        Assert.assertEquals(value.filterEmpty(), "")
    }

    @Test
    fun `filterEmpty should not give empty string if value is not null`() {
        var value: String? = "some"
        Assert.assertNotEquals(value.filterEmpty(), "")
    }

    @Test
    fun `validateUserNamePassword should return false if the string is empty or null`() {
        Assert.assertFalse("".validateUserNamePassword())
        Assert.assertFalse(null.validateUserNamePassword())
    }

    @Test
    fun `validateUserNamePassword should return false if the string is less than 3 characters`() {
        Assert.assertFalse("rah".validateUserNamePassword())
    }

    @Test
    fun `validateUserNamePassword should return true if the string is greater than 3 characters`() {
        Assert.assertTrue("Rahul".validateUserNamePassword())
        Assert.assertTrue("8278232".validateUserNamePassword())
    }
}