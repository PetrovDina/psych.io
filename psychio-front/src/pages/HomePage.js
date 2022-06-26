const HomePage = ({loggedUser}) => {
    return (
      <div>
        <h1>Welcome to psych.io, {loggedUser.username}</h1>
      </div>
    );
  };
  
  export default HomePage;