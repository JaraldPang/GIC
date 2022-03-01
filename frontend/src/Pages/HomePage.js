import '../Styles/App.css';
import Footer from '../Components/Footer'
import Header from '../Components/Header'
import EmployeeList from '../Components/EmployeeList';

function HomePage() {
  return (
    <div className="App">
      <Header />
      <EmployeeList />
      <Footer />
    </div>
  );
}

export default HomePage;
