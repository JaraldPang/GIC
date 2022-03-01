import { GET_EMPLOYEES, ADD_EMPLOYEE, EDIT_EMPLOYEE, SELECT_EMPLOYEE, DELETE_EMPLOYEE } from "../Actions/ActionTypes";

const initialState = { allEmployees: [], selectedEmployee: {}, isReady: false }

function EmployeeReducer(state = initialState, action){
    if (action.type === GET_EMPLOYEES){
        return Object.assign({}, state, {
            allEmployees: action.payload,
            isReady: true
        });
    }

    if (action.type === ADD_EMPLOYEE){
        const newEmployee = action.payload;
        const employeeList = state.allEmployees;
        const newEmployees = employeeList.concat(newEmployee);
        return Object.assign({}, state, {
            allEmployees: newEmployees
        });
    }

    if (action.type === EDIT_EMPLOYEE){
        const newEmployee = action.payload;
        const indexOfOldEmployee = state.employees.indexOf(state.employees.filter(({ id }) => id === newEmployee.id)[0]);
        const newEmployeesList = state.employees;
        newEmployeesList[indexOfOldEmployee] = newEmployee;
        return Object.assign({}, state, {
            allEmployees: newEmployeesList
        });
    }

    if (action.type === SELECT_EMPLOYEE){
        return Object.assign({}, state, {
            selectedEmployee: action.payload
        });
    }

    if (action.type === DELETE_EMPLOYEE){
        return Object.assign({}, state, {
            allEmployees: state.allEmployees.filter(({ id }) => id !== action.payload)
        });
    }

    return {...state}
}

export default EmployeeReducer;