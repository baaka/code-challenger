import { useState, useEffect } from "react";
import { useSnackbar } from "notistack";
import { getTopSubmitters } from "../api/service/submissionService";
import TopSubmitterList from "../component/TopSubmitterList";

const TopSubmittersContainer = ({ setLoading }) => {
  const [topSubmitters, setTopSubmitters] = useState([]);
  const { enqueueSnackbar } = useSnackbar();

  const loadTopSubmitters = () => {
    setLoading(true);
    getTopSubmitters()
      .then((res) => {
        setTopSubmitters(res.data);
      })
      .catch((err) =>
        enqueueSnackbar("Data load failure", {
          variant: "error",
        })
      )
      .finally(() => {
        setLoading(false);
      });
  };

  useEffect(() => {
    loadTopSubmitters();
  }, []);

  return <TopSubmitterList rows={topSubmitters} />;
};

export default TopSubmittersContainer;
