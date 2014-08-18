package com.streambox.celldemo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple CellDemo.
 */
public class CellDemoTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CellDemoTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CellDemoTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testCellDemo()
    {
        assertTrue( true );
    }
}
