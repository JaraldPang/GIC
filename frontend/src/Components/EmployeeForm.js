import React, { useState } from 'react';
import { connect } from "react-redux";
import { Button, Form, FormGroup, Input, Label } from 'reactstrap';
import { addEmployee, editEmployee, selectEmployee } from '../Actions/UserActions';
import { useHistory } from "react-router-dom";
import '../Styles/Body.css';

function mapStateToProps(state){
    return{
        selectedEmployee: state.selectedEmployee
    };
}

function mapDispatchToProps(dispatch){
    return{
        selectEmployee: employee => dispatch(selectEmployee(employee)),
        addEmployee: employee => dispatch(addEmployee(employee)),
        editEmployee: employee => dispatch(editEmployee(employee))
    }
}

function EmployeeForm(props){
    const [employee, setEmployee] = useState(props.selectedEmployee)
    const title = <h2>{props.selectedEmployee.id ? 'Edit Employee' : 'Add Employee'}</h2>;
    const handleSubmit = async(event) => {
        event.preventDefault();
        (props.selectedEmployee.id) ? props.editEmployee(employee) : props.addEmployee(employee);
        props.selectEmployee({});
        routeToHomePage();
    }
    const handleChange = (event) => {
        const value = event.target.value;
        const name = event.target.name;
        let newEmployee = {...employee};
        newEmployee[name] = value;
        setEmployee(newEmployee);
    }
    let history = useHistory();
    const routeToHomePage = () =>{
        props.selectEmployee({});
        history.push('/employee/list')
    }
    return (
        <div className='Body'>
            {title}
            <Form onSubmit={handleSubmit}>
            <FormGroup>
                <Label for="firstName">First Name</Label>
                <Input type="text" name="firstName" id="firstName" value={employee.firstName} required
                    onChange={handleChange}/>
                <Label for="lastName">Last Name</Label>
                <Input type="text" name="lastName" id="lastName" value={employee.lastName} required
                    onChange={handleChange}/>
                <Input type="text" name="email" id="email" value={employee.email} required
                    onChange={handleChange}/>
                <Input type="text" name="number" id="number" value={employee.number} required
                    onChange={handleChange}/>
                <Input type="text" name="gender" id="gender" value={employee.gender} required
                    onChange={handleChange}/>
                <FormGroup className="submit" style={{marginTop: "10%", textAlign: "right"}}>
                    <Button color="primary" type="submit">Save</Button>{' '}
                    <Button color="secondary" onClick={routeToHomePage}>Cancel</Button>
                </FormGroup>
            </FormGroup>
        </Form>
        </div>
    )
}

export default connect(mapStateToProps, mapDispatchToProps)(EmployeeForm);