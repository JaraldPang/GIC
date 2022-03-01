import '../Styles/App.css';
import Footer from '../Components/Footer'
import Header from '../Components/Header'
import EmployeeForm from '../Components/EmployeeForm';

function EditPage() {
  return (
    <div className="App">
      <Header />
      <EmployeeForm />
      <Footer />
    </div>
  );
}

export default EditPage;