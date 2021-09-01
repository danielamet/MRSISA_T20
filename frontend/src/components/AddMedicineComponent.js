import React from 'react';
import Avatar from '@material-ui/core/Avatar';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Alert from '@material-ui/lab/Alert';
import { Paper } from '@material-ui/core';
import AddIcon from '@material-ui/icons/Add';
import Radio from '@material-ui/core/Radio';
import RadioGroup from '@material-ui/core/RadioGroup';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import FormControl from '@material-ui/core/FormControl';
import FormLabel from '@material-ui/core/FormLabel';
import Checkbox from '@material-ui/core/Checkbox';
import FormGroup from '@material-ui/core/FormGroup';
import axios from 'axios';

const paperStyle={padding: "30px 50px",width:370,margin:"20px auto"}
const avatarStyle={backgroundColor: "#1bbd7e"}
const headerStyle={margin:0}
const marginTop={marginTop:5}


function AlertSucc() {
  const [open, setOpen] = React.useState(true);
  return (
    //Popup.alert('You pressed the Save btn')
    <Alert
    >
      Close me!
    </Alert>
  );
}


const AddMedicine=()=>{


    return(
        <Grid>
            <Paper elevation={20} style={paperStyle}>
                <Grid align='center'>
                    <Avatar style={avatarStyle}>
                        <AddIcon/>
                    </Avatar>
                    <h2 style={headerStyle}>Add new medicine</h2>
                </Grid>
                <form>
                    <TextField
                        name="name"
                        variant="outlined"
                        required
                        fullWidth
                        id="name"
                        label="Name"
                        autoFocus
                        style={marginTop}
                    />
                    <TextField
                        variant="outlined"
                        required
                        fullWidth
                        id="type"
                        label="Type"
                        name="type"
                        style={marginTop}
                    />
                    <FormControl component="fieldset" style={marginTop}>
                        <FormLabel component="legend" required>Medicine Shape</FormLabel>
                        <RadioGroup aria-label="MedicineShape" name="MedicineShape" style={{display:'initial'}}>
                            <FormControlLabel value="POWDER" control={<Radio />} label="Powder" />
                            <FormControlLabel value="CAPSULE" control={<Radio />} label="Capsule" />
                            <FormControlLabel value="TABLET" control={<Radio />} label="Tablet" />
                            <FormControlLabel value="FAT" control={<Radio />} label="Fat" />
                            <FormControlLabel value="PASTE" control={<Radio />} label="Paste" />
                            <FormControlLabel value="GEL" control={<Radio />} label="Gel" />
                            <FormControlLabel value="SOLUTION" control={<Radio />} label="Solution" />
                            <FormControlLabel value="SYRUP" control={<Radio />} label="Syrup" />
                        </RadioGroup>
                    </FormControl>
                    <TextField
                        name="composition"
                        variant="outlined"
                        required
                        fullWidth
                        id="composition"
                        label="Composition"
                        autoFocus
                        style={marginTop}
                    />
                    <TextField
                        variant="outlined"
                        required
                        fullWidth
                        id="manufacturer"
                        label="Manufacturer"
                        name="manufacturer"
                        style={marginTop}
                    />
                    <FormControl component="fieldset" style={marginTop}>
                        <FormLabel component="legend" required>Prescription</FormLabel>
                        <RadioGroup aria-label="MedicineShape" name="MedicineShape" style={{display:'initial'}}>
                            <FormControlLabel value="true" control={<Radio />} label="Needed" />
                            <FormControlLabel value="false" control={<Radio />} label="Not needed" />
                        </RadioGroup>
                    </FormControl>
                    <TextField
                        name="medicineSubstituteNames"
                        variant="outlined"
                        fullWidth
                        id="medicineSubstituteNames"
                        label="Substitute Names"
                        autoFocus
                        style={marginTop}
                    />
                    <TextField
                        variant="outlined"
                        fullWidth
                        id="note"
                        label="Additional Note"
                        name="note"
                        style={marginTop}
                    />
                    <Button
                    type="submit"
                    fullWidth
                    variant="contained"
                    color="primary"
                    onClick="AlertSucc()"
                    >
                        submit
                    </Button>
                </form>
            </Paper>
        </Grid>
    );
}

export default AddMedicine;