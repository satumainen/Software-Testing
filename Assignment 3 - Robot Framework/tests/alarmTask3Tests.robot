*** Settings ***
Documentation    A test suite for the Alarm app
Library    ../resources/AlarmLibrary.py

Test Setup    ResetAlarm

*** Keywords ***
ResetAlarm
    [Documentation]    "We reset the alarm FSM before each test case to ensure test independence
    Reset
    Log To Console    "Reset"

Check Arm
    [Arguments]    ${expected}
    Arm
    Result Should Be    ${expected}

Check Close Doors
    [Arguments]    ${expected}
    Close Doors
    Result Should Be    ${expected}
    
#my addition    
Check Open Doors
    [Arguments]    ${expected}
    Open Doors
    Result Should Be    ${expected}
    
Check Disarm
    [Arguments]    ${expected}
    Disarm
    Result Should Be    ${expected}

*** Test Cases ***

Path 1
    Check Disarm    ${2}
    Check Close Doors    ${0}
    Check Disarm    ${2}
    Check Open Doors    ${0}

Path 2
    Check Arm     ${0}
    Check Arm     ${0}
    Check Close Doors    ${1}
    Check Disarm    ${2}
    Check Arm     ${1}

Path 3
    Check Arm     ${0}
    Check Close Doors    ${1}
    Check Arm     ${1}
    Check Open Doors    ${27} #[3,4] works as expected
    Check Disarm    ${2}
    
Path 4
    Check Arm     ${0}
    Check Open Doors    ${-1}
    Check Close Doors    ${1}
    Check Close Doors    ${-1}

Path 5
    Check Open Doors    ${-1}
    Check Close Doors    ${0}
    Check Close Doors    ${-1}

Path 6
    Check Close Doors    ${0}
    Check Arm   ${1}
    Check Open Doors    ${27} #fails at [3,4]
    Check Disarm    ${2}

