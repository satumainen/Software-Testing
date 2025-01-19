*** Settings ***
Documentation    A test suite for the discount app
Library    ../resources/DiscountLibrary.py

*** Test Cases ***

Test ab_valid_1
    Get discount   ${1}    ${True}
    Result should be    ${0}

Test ab_valid_2               
    Get discount   ${10000}    ${True}
    Result should be    ${1}   

Test a_valid
    Get discount   ${10001}    ${True}
    Result should be    ${-1}

Test b_valid
    Get discount   ${0}    ${True}
    Result should be    ${-1}