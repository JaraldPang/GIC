import React from 'react';
import { Table } from 'reactstrap';
import { connect } from "react-redux";
import { Button } from 'reactstrap';
import { useHistory } from "react-router-dom";
import IconButton from '@material-ui/core/IconButton';
import DeleteIcon from '@material-ui/icons/Delete';
import EditIcon from '@material-ui/icons/Edit';
import '../Styles/Body.css';
import { deleteEmployee } from '../Actions/UserActions';

function mapDispatchToProps(dispatch){
    return{
        getEmployees: employeeID => dispatch(deleteEmployee(employeeID))
    }
}

function EmployeeTable(props){
    let history = useHistory();
    const routeToEditPage = (id) =>{
        history.push('/employee/edit')
    }
    const routeToAddPage = () =>{
        history.push('/employee/add')
    }

    const allEmployees = props.allEmployees;
    const employeeTable = 
    <Table className="mt-4" style={{background:'white', margin:'1%', padding:"1%", borderRadius:"5px", border:"hidden"}}>
        <tbody>
        <tr style={{textAlign:'left'}}>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Number</th>
            <th>Gender</th>
        </tr>
        {allEmployees.map((employee, index) => (
        <tr style={{paddingLeft:'3%'}} key={index}>
            <td style={{whiteSpace: 'nowrap', width: "5%", textAlign:'left', verticalAlign:'middle'}}>{employee.id}</td>
            <td style={{whiteSpace: 'nowrap', width: "25%", textAlign:'left', verticalAlign:'middle'}}>{employee.firstName}</td>
            <td style={{whiteSpace: 'nowrap', width: "25%", textAlign:'left', verticalAlign:'middle'}}>{employee.lastName}</td>
            <td style={{whiteSpace: 'nowrap', width: "20%", textAlign:'left', verticalAlign:'middle'}}>{employee.email}</td>
            <td style={{whiteSpace: 'nowrap', width: "20%", textAlign:'left', verticalAlign:'middle'}}>{employee.number}</td>
            <td style={{whiteSpace: 'nowrap', width: "20%", textAlign:'left', verticalAlign:'middle'}}>{employee.gender}</td>
            <td style={{width:"5%", textAlign: 'right'}}>
                <IconButton onClick={()=>{routeToEditPage(employee)}} className="EditButton">
                    <EditIcon />
                </IconButton>
            </td>
            <td style={{width:"5%", textAlign:'left'}}>
                <IconButton onClick={()=>{if (window.confirm("Are you sure?")) props.deleteEmployee(employee.id)}} className="DeleteButton">
                    <DeleteIcon />
                </IconButton>
            </td>
        </tr>
        ))}
        </tbody>
    </Table>

    return (
        <div className='Body'>
            {employeeTable}
        </div>
    )
}

export default connect(null, mapDispatchToProps)(EmployeeTable);