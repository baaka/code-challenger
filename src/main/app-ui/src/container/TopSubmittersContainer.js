import { useState, useEffect } from "react";
import { getTopSubmitters } from "../api/service/submissionService";
import TopSubmitterList from "../component/TopSubmitterList";

const TopSubmittersContainer = () => {
  const [topSubmitters, setTopSubmitters] = useState([]);

  const loadTopSubmitters = () => {
    getTopSubmitters().then((res) => {
      setTopSubmitters(res.data);
    });
  };

  useEffect(() => {
    loadTopSubmitters();
  }, []);

  return <TopSubmitterList rows={topSubmitters} />;
};

export default TopSubmittersContainer;
