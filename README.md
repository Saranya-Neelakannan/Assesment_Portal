## ASSESSMENT PORTAL

## ADMIN
    ## I. ADMIN 
        1. USERNAME
        2. PASSWORD
        3. FULL NAME
        4. QUESTIONS GROUP AS LIST

    ## II. ADMIN ACTIONS
        1. ASSIGN ASSESSMENTS TO THE EMPLOYEE
        2. CREATE NEW ASSESSMENT QUESTIONS
        3. ADMIN LOGIN VALIDATION
        4. CAN VIEW ALL EMPLOYEE DETAILS AND ASSESSMENTS
        5. CAN VIEW ALL QUESTIONS ASSOCIATED WITH HIM


## EMPLOYEE
    ## I. EMPLOYEE
        1. USERNAME
        2. PASSWORD
        3. FULLNAME
        4. ASSESSMENT MARKS as MAP(ID, MARKS)
        5. ASSESSMENT STATUS AS MAP(GROUP ID, STATUS)
        6. ADMIN USERNAME

    ## II. EMPLOYEE ACTIONS
        1. LOGIN
        2. REGISTER
        3. BEGIN ASSESSMENT
        4. VIEW ALL HIS ASSESSMENT RESULTS
        5. VIEW PENDING ASSESSMENTS
        6. VIEW ALL ASSESSMENTS
        7. VIEW COMPLETED ASSESSMENTS
        8. VIEW PARTICULAR ASSESSMENT MARKS

## QUESTIONS
    1. QUESTION ID
    2. QUESTIONS
    3. ANSWER
    4. OPTIONS AS LIST
    5. ADMIN USERNAME


## OVERALL STRUCTURE

    ## I. CONCRETE
        1. QUESTIONS
        2. EMPLOYEE
        3. ADMIN

    ## II. DATA
        1. QUESTIONS DATA
        2. EMPLOYEE DATA
        3. ADMIN DATA

    ## III. SERVICE
        1. ADMIN SERVICE
        2. EMPLOYEE SERVICE

    ## IV. CONTROLLER
        1. ADMIN CONTROLLER
        2. EMPLOYEE CONTROLLER

    ## V. EXCEPTIONS
        1. EMPLOYEE NOT FOUND EXCEPTION
        2. ASSESSMENT NOT FOUND EXCEPTION
        3. ADMIN NOT FOUND EXCEPTION
    


