import { useFormik } from 'formik';
import * as Yup from 'yup';
import { toast } from 'react-toastify';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import moment from 'moment'
import UserService from '../services/UserService';
import { useNavigate } from 'react-router-dom';

const validationSchema = Yup.object({

    username: Yup.string()
        .required('Required'),
    password: Yup.string()
        .required('Required')


});


const LoginPage = () => {

    const navigate = useNavigate();

    const formik = useFormik({
        initialValues: {
            username: '',
            password: '',

        },
        validationSchema: validationSchema,
        onSubmit: (values) => {
            UserService.login(values).then((response) => {
                console.log(response);
                if (!response){
                    toast.error('Invalid username and/or password');
                    return;
                }
                toast.success('Successful login. Redirecting...');
                localStorage.setItem("LOGGED_USERNAME", response.username);
                localStorage.setItem("LOGGED_ROLE", response.role);
                navigate("/");
                formik.resetForm();
            });
        },
    });


    return (
        <div>
            <h1>Log in</h1>
            <Form onSubmit={formik.handleSubmit}>
                <Row className="mb-3 mt-5">
                    <Form.Group as={Col} md="4" className="offset-2">
                        <Form.Label>Username:</Form.Label>
                        <Form.Control
                            id="username"
                            name="username"
                            type="text"
                            value={formik.values.username}
                            onChange={formik.handleChange}
                        />
                        {formik.touched.username && formik.errors.username && (
                            <small className="form-text text-danger">{formik.errors.username}</small>
                        )}
                    </Form.Group>
                    <Form.Group as={Col} md="4">
                        <Form.Label>Password:</Form.Label>
                        <Form.Control
                            id="password"
                            name="password"
                            type="password"
                            value={formik.values.password}
                            onChange={formik.handleChange}
                        />
                        {formik.touched.password && formik.errors.password && (
                            <small className="form-text text-danger">{formik.errors.password}</small>
                        )}
                    </Form.Group>
                </Row>

                <Button variant="success" type="submit">
                    Log in
                </Button>
            </Form>
        </div>
    );
};

export default LoginPage;