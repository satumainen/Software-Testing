*** Settings ***
Documentation    A test suite for the discount app
Library    ../resources/DiscountLibrary.py

*** Test Cases ***
Test b1g1_0
    Get discount   ${0}    ${True}
    Result should be    ${-1}

Test b1g1_1
    Get discount   ${1}    ${True}
    Result should be    ${0}

Test b1g2_1
    Get discount   ${1}    ${False}
    Result should be    ${0}

Test b2g1_80
    Get discount   ${80}    ${True}
    Result should be    ${1}

Test b2g2_80
    Get discount   ${80}    ${False}
    Result should be    ${0}

Test b3g1_120
    Get discount   ${120}    ${True}
    Result should be    ${1}

Test b3g1_10000
    Get discount   ${10000}    ${True}
    Result should be    ${1}

Test b3g1_120
    Get discount   ${120}    ${False}
    Result should be    ${1}

Test b3g1_10000
    Get discount   ${10000}    ${False}
    Result should be    ${1}

Test b3g1_10001
    Get discount   ${10001}    ${True}
    Result should be    ${-1} #fails

